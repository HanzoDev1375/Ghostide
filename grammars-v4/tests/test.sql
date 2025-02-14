


MERGE INTO bq_test_ds.transactions_v3 sl_existing
    USING ( WITH sl_incoming AS (
                    WITH cte AS (
                            SELECT  '12345' AS transaction_id
                                    , TIMESTAMP '2021-03-01' AS transaction_date
                                    , 300 AS amount
                                    , 'CA' AS location_info
                                    , 'Dua' AS seller_info  )
                    SELECT *
                    FROM cte ) SELECT   s/* All line present in the source with their key */l_incoming.transaction_id AS sl_pseudo_transaction_id
                                        , sl_incoming.*
            FROM sl_incoming
                LEFT JOIN bq_test_ds.transactions_v3 sl_existing
                    ON ( sl_incoming.`transaction_id` = sl_existing.`transaction_id`
                            AND sl_existing.end_ts IS NULL )
            WHERE sl_existing.`transaction_id` IS NULL
                OR sl_existing.transaction_date < sl_incoming.transaction_date
            UNION ALL
            SELECT  N/* All line present in the source and target that are current in the target */ULL AS sl_pseudo_transaction_id
                    , sl_incoming.*
            FROM sl_incoming
                INNER JOIN bq_test_ds.transactions_v3 sl_existing
                    ON ( sl_incoming.`transaction_id` = sl_existing.`transaction_id`
                            AND sl_existing.end_ts IS NULL )
            WHERE sl_existing.transaction_date < sl_incoming.transaction_date ) sl_incoming
        ON ( sl_incoming.sl_pseudo_transaction_id = sl_existing.transaction_id )
WHEN MATCHED THEN
    UPDATE SET  end_ts = CURRENT_TIMESTAMP()
WHEN NOT MATCHED THEN
    INSERT ( `transaction_id`
                , `transaction_date`
                , `amount`
                , `location_info`
                , `seller_info`
                , `start_ts`
                , `end_ts` )
    VALUES ( sl_incoming.`transaction_id`
                , sl_incoming.`transaction_date`
                , sl_incoming.`amount`
                , sl_incoming.`location_info`
                , sl_incoming.`seller_info`
                , CURRENT_TIMESTAMP()
                , NULL )
;
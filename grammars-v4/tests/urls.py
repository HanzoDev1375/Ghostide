from django.urls import path
from views import hello

urlpatterns = [
    path('hello/', hello),
]
print(urlpatterns[0])
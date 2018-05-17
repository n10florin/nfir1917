from django.urls import path

from . import views

app_name = 'note'
urlpatterns = [
    path('', views.IndexView.as_view(), name='index'),
    path('add/', views.AddNotaView.as_view(), name='add'),
]

# Create your views here.
from django.urls import reverse
from django.views.generic import ListView, CreateView

from note.models import Nota


class IndexView(ListView):
    template_name = 'note/index.html'

    def get_queryset(self):
        return Nota.objects.all()


class AddNotaView(CreateView):
    model = Nota
    fields = ['nr_matricol', 'materie', 'nota']

    def get_success_url(self):
        return reverse('note:index')

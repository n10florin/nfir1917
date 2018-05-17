from django.core.exceptions import ValidationError
from django.db import models

# Create your models here.


def validate_nr_matricol(nr_matricol):
    if nr_matricol < 1 or nr_matricol > 1000:
        raise ValidationError('Numarul matricol introdus nu este corect')


def validate_materie(materie):
    if len(materie) < 4 or len(materie) > 20:
        raise ValidationError('Lungimea materiei este invalida')


def validate_nota(nota):
    if nota < 1 or nota > 10:
        raise ValidationError('Nota introdusa nu este corecta')


class Nota(models.Model):
    nr_matricol = models.IntegerField(validators=[validate_nr_matricol])
    materie = models.CharField(max_length=50, validators=[validate_materie])
    nota = models.IntegerField(validators=[validate_nota])

    def __str__(self):
        return '{0} {1} {2}'.format(self.nr_matricol, self.materie, self.nota)

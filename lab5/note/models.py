from django.core.exceptions import ValidationError
from django.db import models

# Create your models here.


class Nota(models.Model):
    nr_matricol = models.IntegerField()
    materie = models.CharField(max_length=50)
    nota = models.IntegerField()

    def __str__(self):
        return '{0} {1} {2}'.format(self.nr_matricol, self.materie, self.nota)

    def clean(self):
        errors = dict()
        if self.nr_matricol < 1 or self.nr_matricol > 1000:
            errors['nr_matricol'] = ValidationError('Numarul matricol introdus nu este corect')
        if len(self.materie) < 4 or len(self.materie) > 20:
            errors['materie'] = ValidationError('Lungimea materiei este invalida')
        if self.nota < 1 or self.nota > 10:
            errors['nota'] = ValidationError('Nota introdusa nu este corecta')
        if errors:
            raise ValidationError(errors)


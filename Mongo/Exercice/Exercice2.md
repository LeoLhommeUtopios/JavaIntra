## API gestion pointage

- endPoint pour pointer s'il n'existe pas de Clocking  pour ajd le créer. Sinon on viens fixer la date de endclocking de notre document
parametres (id user);

- endPoint pour recuperer les clockIn d'un utilisateur 
parametre (id user)

- end point pour recuperer tout les clockIn de tout nos utilisateurs entre 2 dates
parametres (dateStart, dateEnd)

ClockIn :
    _id
    idUser
    date startClocking 
    date endClocking
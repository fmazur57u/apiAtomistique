# apiAtomistique
Api rest qui permet de récupérer des informations à partir d'un éléments de la classification périodiques des éléments.

1) premier endpoint: /basic_info/{symbole}/{a}:
   A partir d'un symbole comme H, H+, cl- et du nombre de masse a, le programme va récupérer le nombre de protons, neutrons et électrons de l'atome, isotopes ou l'ions qui correspond au symbole.
2) deuxiéme endpoint: /basic_info_isotopes/{z}/{a}
   A partir d'un numéros z et du nombre de masse a, le programme va dire a quel élement correspond cette isotope ainsi que le nombre protons, neutrons et électrons de l'isotopes.

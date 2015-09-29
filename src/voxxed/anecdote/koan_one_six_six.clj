(ns voxxed.anecdote.koan-one-six-six)

;For any orderable data type it's possible to derive all of the basic comparison operations (<, ≤, =, ≠, ≥, and >)
; from a single operation (any operator but = or ≠ will work). Write a function that takes three arguments, a
; less than operator for the data and two items to compare.
; The function should return a keyword describing the relationship between the two items.
; The keywords for the relationship between x and y are as follows:
;x = y → :eq
;x > y → :gt
;x < y → :lt

;(= :gt (__ < 5 1))

;mine
(fn [ltop x y]
  (cond
    (and (not (ltop x y)) (not (ltop y x))) :eq
    (ltop x y) :lt
    :else :gt))

;one of contributors I "follow"
#({[% %] :eq [%2 %] :lt [% %2] :gt} [(%3 %4 %5) (%3 %5 %4)]) false true


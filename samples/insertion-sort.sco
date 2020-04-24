; Return a new list where the element x is merged with
; the sorted lists l1 and l2
merge: (x l1 l2) =>
    (if (and (> (size l2) 0) (< x (car l2)))
      (append l1 (x) l2)
    (if (and (> (size l2) 0) (== 0 (size l1)))
      (merge x ((car l2)) (cdr l2))
    (if (== 0 (size l2))
      (append l1 (x))
    (merge x (append l1 ((car l2))) (cdr l2)))))

; Returns (2 4 5 8)
;(merge 9 () (2 5 8))

; Insert x into the sorted list l.
; The returned list is still sorted.
insert: (x l) => (merge x () l)

; Insertion sort.
; Visit each element of the list and
; insert it into a sorted partial list.
insertion-sort: (l) => (fold-left (lambda (acc curr) (insert curr acc)) () l)

list: (7 1 5 2 9 15 3 42 3)

; Invoke insertion sort on a list
(insertion-sort list)

; Return a new list where the element x is merged with
; the sorted lists l1 and l2
(define merge
  (lambda (x l1 l2)
    (if (< x (car l2))
      (append l1 (x) l2)
      (merge x (append l1 (car l2)) (cdr l2)))))

; Returns (2 4 5 8)
(merge 4 () (2 5 8))

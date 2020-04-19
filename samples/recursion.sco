(define fun
  (lambda (x)
    (
      (print "1 " x)
      (print "2 " x)
      (if (< x 0)
        0
        (fun (- x 1))))))

(fun 1)

;(define fun
;  (lambda ()
;    ((print 1) (print 2) (print 3))))

;(fun)
;(fun)

((lambda (x) ((print 1))) 1)
(define make-adder
    (lambda [a]
        (lambda [b]
            (+ a b))))

(define add1 (make-adder 1))

(define fourtyone 41)

(add1 fourtyone)
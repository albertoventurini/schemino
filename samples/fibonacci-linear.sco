; Recursive function to calculate the n-th Fibonacci number
(define fib
  (lambda (n)
    (fib-rec 1 0 n)))

(define fib-rec
  (lambda (acc prev n)
    (
      (print "acc = " acc ", prev = " prev ", n = " n)
      (if (= 0 n)
        acc
        (fib-rec (+ acc prev) acc (- n 1))))))

; Calculate the 10th Fibonacci number
(fib 10)

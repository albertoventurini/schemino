; Recursive function to calculate the n-th Fibonacci number
fib:
  (lambda (n)
    (if (< n 2)
        1
        (+ (fib (- n 1))
           (fib (- n 2)))))

; Calculate the 10th Fibonacci number
(fib 10)

; Recursive function to calculate the n-th Fibonacci number
fib: (n) => (fib-rec 1 0 n)

; Recursive helper function
fib-rec: @tailrec (acc prev n) =>
  (if (== 0 n)
    acc
    (fib-rec (+ acc prev) acc (- n 1)))

; Calculate the 100th Fibonacci number.
; Because we use a O(n) algorithm, we can calculate, in a reasonable amount of time,
; a bigger Fibonacci number than the O(n^2) algorithm.
(fib 100)

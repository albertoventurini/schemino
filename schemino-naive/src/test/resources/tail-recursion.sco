recurse: @tailrec [x] =>
  (if (== 0 x)
    x
    { (print x) (recurse (- x 1)) }
  )

; Without tail recursion, this throws a StackOverflowException
(recurse 1000)
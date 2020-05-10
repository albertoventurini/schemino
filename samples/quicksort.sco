quicksort: [items] =>
    (if (== 0 (size items))
        []
        {
            first: (car items)
            smallerSorted: (quicksort (filter (lambda [x] (< x first)) items))
            largerSorted: (quicksort (filter (lambda [x] (> x first)) items))

            (append smallerSorted [first] largerSorted)
        }
    )

(quicksort [59 27 10 1 100 32 37 19 7 7 62])


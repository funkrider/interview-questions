(ns interview-questions.18-Merge-sorted-array)

;;; Given two sorted arrays, A & B, where A is large enough to include B,
;;; write a function that will merge the two arrays without any other data
;;; structures and maintain sort order.

;;; e.g. [1 3 5 0 0 0] [2 4 6] -> [1 2 3 4 5 6]

;;; Clojure works with native arrays using int-array, aget, aset, alength functions.
;;; This solution is super imperative! Not really what clojure is about :-(

(defn merge-arrays [*arr-a* *arr-b* a-count b-count]
  "Assumes a and b are int-arrays. Array a has empty index positions
   at the end of equal number to the data items in a."
  (loop [arr *arr-a*
         i   (dec (alength arr))
         a-i (dec a-count)
         b-i (dec b-count)]
    (if (< i 0)
      (into [] arr) ;; output the array as clojure vector for testing and REPL
      (if (or (< b-i 0)
              (>= (aget arr a-i) (aget *arr-b* b-i)))
        (do
          (aset arr i (aget arr a-i))
          (recur arr (dec i) (dec a-i) b-i))
        (do
          (aset arr i (aget *arr-b* b-i))
          (recur arr (dec i) a-i (dec b-i))))))
    )

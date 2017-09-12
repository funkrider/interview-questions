(ns interview-questions.16-Zero-sum-set)

;;; Write a function that takes a list of integers and returns
;;; a sequence of all possible groups of 3 integers from the
;;; input that sum to 0.
;;; E.g. (-1, 0, 1, 2, -1, -4) ->
;;; ( (-1, 0, 1),  (-1, -1, 2) )

;;; sort -> (-4, -1, -1, 0, 1, 2)

(defn three-sum [xs]
  (let [c (count xs)]
    (->>
      (for   ;; iterate every permutation of items from a sequence
           [x (range (- c 2))
            y (range (inc x) (- c 1))
            z (range (inc y) c)]
        (map (partial nth xs) (list x y z))) ;; return values
      (filter #(= 0 (apply + %)))       ;; filter where sum 0
      (map sort)                        ;; sort each set
      (distinct)                        ;; return unique sets
      )
    )
  )

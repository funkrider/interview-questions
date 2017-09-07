(ns interview-questions.03-FindChange)

;;;
;; Find the minimum number of coins required to make
;; a given amount x.
;;;

;; Assumptions the available coin set is a closure sorted set of #{1 5 10 25}
;; Example #{1 3 4} target is 6 -> 3,. Trick case where
;; one item is more than 50% of next largest plus the next smallest.
;; Can verify by repeating the function without the largest used coin.
;; Assume that the set must contain a 1 coin therefore no positive amount is
;; out of range.
;; Assume target is also positive and above 0.


(defn find-equal-or-first-lower [coins x]
"Goes through a sorted set and returns the greatest item equal to or less than x"
(apply max (filter #(<= % x) coins))
)

(defn find-change [coins x]
"Find largest coin from available set, then iterate on remainder"
  (loop [change [] 
         val x]
    (let [coin (find-equal-or-first-lower coins val)
          rem (- val coin)]
      (if (< rem 1)
        (conj change coin) 
        (recur (conj change coin) rem )))))
(ns interview-questions.17-Zero-sum-sub-array)

;;; Write a function that given a sequence of integers will
;;; return a sub-sequence (i.e. order contiguous) that sums
;;; to zero. Only one is required else return nil.

;;; Rationale is to create a vector of consecutive sums, start at 0.
;;; e.g. (1 2 -5  1  2 -1)
;;;   -> [0 1  3 -2 -1  1 0]
;;; Here we see there are two 0's (index 0 and 6).
;;; This means that the sub-vector 0 to 5 (inclusive) sum to 0.
;;; Likewise there are two 1's (index 1 and 5) meaning
;;; that the sub-vector 1 to 4 (inclusive) sum to 0.
;;; Given that we don't regard the entire sequence as a sub-sequence
;;; there is only one result here that we shall return.

(defn zero-sub [xs]
  (->> xs
      (reduce #(conj %1 (+ (last %1) %2)) [0])      ;; accumulate total
      (reduce-kv  (fn [acc i v]                     ;; Create map of val (indexes)
                    (update-in acc [v] conj i))
                  {} )
      (filter #(and (> (count (second %1)) 1)       ;; Remove those with 1 elem
                    (not= (second %1) (list (count xs) 0)))) ;; Remove full range
      (map last)                                    ;; Only need index point
      (map (fn [[e s & _]] (subvec (vec xs) s e) )) ;; Get the sub-vec
    ))

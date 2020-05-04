(ns interview-questions.04-Number-of-1s-in-binary)

;; Find the number of 1's in the binary
;; representation of an integer

;; ones(2) = 1
;; ones(3) = 2
;; ones(5) = 2
;; ones(7) = 3

;;(bit-and 1 x)

(defn ones
  ([num] (ones num 0))
  ([num count]
    (loop [total count
           newnum num]
      (if (= 0 newnum)
        total
        (recur (+ total (bit-and 1 newnum))
               (bit-shift-right newnum 1))))))

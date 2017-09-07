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
    (let [total (+ count (bit-and 1 num))
          newnum (bit-shift-right num 1)]
      (if (= 0 newnum)
        total
        (recur newnum total)))))
(ns interview-questions.24-sort-stack)

;; Given a stack sort the stack using no more than one additional stack

;; Assume that we are to do the shuffling by hand.
;; Assume integer stacks and we want Descending.
;; Assume positive integers.

;; Use stack B as descending stack,
;; take the two top items,
;; take from B into A until head of B is > max top 2
;; put max into B, min into A
;; recur until A is empty, return B.

(defn sort-stack-new [l]
  (loop [a l
         b '()]
    (if (empty? a)
      b
      (let [[ax & axs] a
            [b-take b-drop] (split-with (partial > ax) b)]
        (recur (into axs b-take) (conj b-drop ax))))))

(sort-stack-new '(2 3 1 0 7 8))

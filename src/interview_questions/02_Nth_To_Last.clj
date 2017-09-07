(ns interview-questions.02-Nth-To-Last)

;;;
;; Given a singly linked list find the nth to last element
;;;

(defn nth-to-last [a-list n]
  (let [c (count a-list)
        x (- c n 1)]
    (if (< x 0)
      nil
      (nth a-list x))) )
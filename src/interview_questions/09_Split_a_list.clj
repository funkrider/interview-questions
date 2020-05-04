(ns interview-questions.09-Split-a-list)

;;; Write a function that takes a linked list
;;; and divides it into 2 equal parts returning
;;; those parts (in place modification isn't
;;; clojure-esque)

;;; Must first calculate the length - then
;;; the middle point. Middle item set next = nil
;;; return new lists

(defn divide-list [coll]
  (let [split (-> (count coll) (/ 2) (int))]
    (split-at split coll)) ;; [(take n coll) (drop n coll)]
  )

;; Not the best as it requires 2 iterations, first to count
;; and then to return. Could use two pointers instead, advancing
;; the second pointer 2 at a time. When reaches the end then
;; start the split and return the second linked list.
;; Catch the odd number situation - and confirm function.

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
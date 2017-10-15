(ns interview-questions.19-Balanced-binary-tree)

;;; Create a function that will return true where a tree is a balanced
;;; binary tree and false where it is not. Balanced is defined as all
;;; sub-trees having only child branches that are within 1 of the same size.

;;;         1
;;;    2         3
;;;  4   5     6   7
;;;   8      9 10 11 12
;;;         13

;;; This tree is defined as balanced. There are no sub-trees that are
;;; more than one different.

;;; Assume tree node is a map in form {:value 99 :left nil :right :nil)

(defn is-balanced-binary-tree?
  ([n] (is-balanced-binary-tree? n 0))
  ([n i]
   (if (nil? n)
     0
     (let [left (is-balanced-binary-tree? (:left n))
           right (is-balanced-binary-tree? (:right n))]
       (if (some #{-1} [left right])
         -1
         (if (> 1 (Math/abs (- left right)))
           -1
           (inc (max left right))))))))

(ns interview-questions.10-Level-order-tree)

;;; Given a tree of nodes traverse the tree
;;; and print each value in order of each
;;; level. For example:
;;;    1
;;;  2   3
;;; 4 5 6 7
;;;
;;; -> 1 2 3 4 5 6 7

(defn get-children [node]
  "takes a map and returns the value of :left and :right as a list. Nul is
  not added to the list and therefore may be empty."
  (filter some? ((juxt :left :right) node))
  )


(defn level-order [root]
  "Outputs the values of a tree in order. It assumes that nodes are of
  {:value 1 :left nil :right nil} map."
  (loop [curr root
         queue (get-children curr)
         out []]

    (if (nil? curr)
      (apply str out)
      (recur
        (first queue)
        (into (rest queue) (get-children (first queue)))
        (conj out (:value curr)))))
  )
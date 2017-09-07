(ns interview-questions.05-Valid-Binary-Search-Tree
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))


;; Write a function that validates a tree, such that
;; the tree is a binary search tree. All right nodes
;; should be greater and all left nodes less than or
;; equal in value to all parents.
;; Assume integer values.

;;     5
;;   2    7
;; 1   3 6  8

;; Node example
(def a-node {:value 1 :left nil :right nil})

(defn isBST
  ([n]
   (isBST n Integer/MIN_VALUE Integer/MAX_VALUE))
  ([n min max]
   (let [v (:value n)]
     (cond
       (= v nil) true
       (<= v min) false
       (> v max) false
       (and (isBST (:left  n) min v)
            (isBST (:right n) v max)) true
       :slse false
       ))))

(s/def ::value integer?)
(s/def ::right (s/nilable ::node))
(s/def ::left (s/nilable integer?))
(s/def ::node (s/keys :req [::value ::left ::right]))
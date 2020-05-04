(ns interview-questions.05-Valid-Binary-Search-Tree
  (:require [clojure.spec.alpha :as s]
            [clojure.zip :as zip]
            [clojure.data.xml :as dx]
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

;; Spec the node map just for fun
(s/def ::value integer?)
(s/def ::right (s/nilable ::node))
(s/def ::left (s/nilable integer?))
(s/def ::node (s/keys :req [::value ::left ::right]))

;; This function is recursive so will eventually max out the stack.
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
       :else false))))

;; We can just use nested vectors:
;;           5
;;      3         7
;;   2    4    6    8


(defn queue [& vals]
  (apply conj clojure.lang.PersistentQueue/EMPTY vals))

(defn conj-when-some [coll x]
  (apply conj coll x))

(defn valid-bst [bst]
  (loop [q   (queue {:loc bst
                     :min Integer/MIN_VALUE
                     :max Integer/MAX_VALUE})]
    (let [{:keys [loc min max]} (first q)
          is-branch (vector? loc)
          val  (if is-branch
                 (first loc) ;; We store in index 0
                 loc)
          is-valid (< min val max)
          left  (when is-branch (nth loc 1))
          right (when is-branch (nth loc 2))]
      (if (or (not is-valid)
              (not (or (seq (rest q))
                        left
                        right)))
        is-valid
        (recur (-> q
                   (rest)
                   (conj-when-some (and left  [{:loc left  :min min :max val}]))
                   (conj-when-some (and right [{:loc right :min val :max max}])))) ))))

(def bst [5 [3 2 4] [7 6 8]])
(def nobst [5 [3 2 4] [7 9 8]])
(valid-bst bst)
(valid-bst nobst)

(ns interview-questions.12-Permutations
  (:require [clojure.math.combinatorics :as combo]))

;;; Given a string for example "abc" return a list
;;; of all possible permutations of the characters.
;;; (abc, acb, bac, bca, cab, cba)

;;; For loops in Clojure iterate in combination the given lists.
;;; The right most list iterates fastest. A sequence of results is
;;; created for each combination.
;;; For example:
;;; for [x '(\a \b) y '(1 2)] [x y] -> ([\a 1] [\a 2] [\b 1] [\b 2])
;;;
;;;

(defn test-combo [xs]
  (combo/permutations xs))

(defn remove-nth [coll n]
  "Removes the item from the sequence at the given index."
  (let [v (vec coll)]
    (if (or (empty? v)
            (< n 0)
            (>= n (count v)))
      coll
      (concat (subvec v 0 n) (subvec v (inc n))))
    )
  ;(into (drop (inc n) coll) (reverse (take n coll)))
  )

(defn append-index [coll]
  "Takes a sequence and returns a new one with the item
  in a vector paired with the index. For example
  '(a b c) -> '([0 a] [1 b] [2 c])"
  (map-indexed #(conj [%1] %2) coll))

(defn permutation [xs]
  "Calculates a sequence of all permutations of a given
  sequence. Sequence does not need to be unique."
  (let [i-xs (append-index xs)]
  (if (= (count xs) 1)
    (list xs)
    (for [x i-xs
          y (permutation (remove-nth xs (first x)))]
      (cons (last x) y)))))


;;; A different implementation using rotations
;;; and mapping over those.

(defn rotations [a-seq]
  "Returns all rotations of a sequence.
  E.g. (rotations (range 5)) ->
  ( (1 2 3 4 0) (2 3 4 0 1) (3 4 0 1 2)
    (4 0 1 2 3) (0 1 2 3 4) )"
  (let [a-vec (vec a-seq)]
    (for [i (range (count a-vec))]
      (concat (subvec a-vec i) (subvec a-vec 0 i)))))

(defn permutations-rot [a-set]
  "Returns all permutations of a set."
  (if (empty? a-set)
    (list ())
    (mapcat
      (fn [[x & xs]] (map #(cons x %) (permutations-rot xs)))
      (rotations a-set))))

(defn permutations-set [xs]
  (if (= 1 (count xs))
    (list xs)
    (for [x xs
          y (permutations (disj (set xs) x))]
      (cons x y))))
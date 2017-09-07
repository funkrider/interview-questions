(ns interview-questions.06-Anagram
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

;;; Write a function to determine if one string is an
;;; anagram of another. Assume all lower western chars.
;;; Ignore spaces and punctuation.

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(defn char-range-hash-set [start end]
  (apply hash-set (char-range start end)))

(defn char-count [x]
  (reduce (fn [acc v]
            (let [acc-v (acc v 0)]
              (assoc acc v (inc acc-v)))) {} x ))

(defn is-anagram?
  ( [a b] (is-anagram? a b \a \z) )
  ( [a b s e]
    (let [ac (->> a
             (.toLowerCase)
             (filter (char-range-hash-set s e))
             (char-count))  ;; same as frequencies func.
          bc (->> b
             (.toLowerCase)
             (filter (char-range-hash-set s e))
             (char-count))] ;; same as frequencies func.
    (= ac bc))))


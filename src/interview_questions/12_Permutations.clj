(ns interview-questions.12-Permutations)

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

(defn remove-nth [coll n]
  "Removes the item from the sequence at the given index."
  (into (drop (inc n) coll) (reverse (take n coll))))

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


; Debugging the permuation function is as follows:
; permutation '(\a \b \c)
; i-xs -> '([0 \a] [1 \b] [2 \c])
; count xs -> 3 :. take else branch
; for [x '([0 \a] [1 \b] [2 \c])  ; x is first bound to [0 \a]
;      y (permuation (remove '(\a \b \c) 0)]
; permutation '(\b \c)
; i-xs -> '([0 \b] [1 \c])
; count xs -> 2 :. take else branch
; for [x '([0 \b] [1 \c])
;      y (permutation (remove '(\b \c) (first [0 \b])
; permutation '(\c)
; i-xs -> '([0 \c])
; count xs -> 1 :. take if branch
; return '( (\c) )
;      y -> '( (\c) )
; (cons \b (\c) -> (\b \c)
; for [x '([0 \b] [1 \c])
;      y (permutation (remove '(\b \c) (first [1 \c])
; permutation '(\b)
; i-xs -> '([0 \b])
; count xs -> 1 :. take if branch
; return '( (\b) )
;      y -> '( (\b) )
; (cons \c (\b) -> (\c \b)
; returns '((\b \c) (\c \b))
;      y -> '((\b \c) (\c \b))
; (cons \a (\b \c) -> (\a \b \c)
; (cons \a (\c \b) -> (\a \c \b)
; returns '((\a \b \c) (\a \c \b))
;
; x -> [1 \b] y -> '((\a \c) (\c \a))
; returns '((\b \a \c) (\b \a \b))    etc...



;(defn for-split [xs]
;  (loop [i 0
;         out '()]
;    (if (> (inc i) (count xs))
;      out
;      (let [pre (nth xs i)
;            post (remove-nth xs i)
;            pair (vector  (nth xs i) (remove-nth xs i))]
;        (recur (inc i) (conj out pair)))))
;  )

;
;(defn permutations [xs]
;  (if (= 1 (count xs))
;    (list xs)
;    (for [x xs
;          y (permutations (disj (set xs) x))]
;      (cons x y))))
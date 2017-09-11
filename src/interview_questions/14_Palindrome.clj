(ns interview-questions.14-Palindrome)

;;; Given a linked list write a function to determine
;;; if the sequence is a palindrome.

;;; (1 2 3 2 1) -> true
;;; (1 2 3 1 1) -> false

;;; Need to know the length of the list - so get as first step
;;; Can split in half - and reverse one, both must be equal

(defn palindrome? [xs]
  (palindrome-rev? xs) ;; can swap out for testing
  )

(defn palindrome-rev? [xs]
  (if (empty? xs)
    true
    (= (reverse xs) (seq xs))))

(defn palindrome-rec? [xs]
  (if (or (empty? xs) (= 1 (count xs)))
    true
    (if (not= (first xs) (last xs))
      false
      (recur (drop-last (rest xs))))))

(defn palindrome-split? [xs]
  (let [c (/ (count xs) 2)]
    (if (<= c 1)
      true
      (let [x (take (Math/floor c) xs)
            y (reverse (drop (Math/ceil c) xs))]
        (= x y)
        ))))
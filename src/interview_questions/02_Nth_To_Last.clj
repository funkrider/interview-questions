(ns interview-questions.02-Nth-To-Last
  (:import  [java.util LinkedList Queue]))

;;;
;; Given a singly linked list find the nth to last element
;;;

;; This implmentation is bad because we must
;; traverse the list once to count and then
;; again to get the element.
(defn nth-to-last
  [a-list n]
  (let [c (count a-list)
        x (- c n 1)]
    (if (< x 0)
      nil
      (nth a-list x))))

#_(nth-to-last '(1 2 3 4 5 6 7 8 9 10 11 12 13 14)  3)

;; A sliding-buffer is the sort of thing
;; that we want. It is essentially a reduction
;; on the list but we keep a buffer of size n.
;; Clojure actually has a Queue structure
;; it is not used very often. (def queue clojure.lang.PersistentQueue/EMPTY)
;; It would have to be an atom - holding a queue to mutate.
(defn nth-to-last-redux
  [a-list n]
  (-> (reduce (fn [buf i]
                (let [b-size (.size buf)]
                  (when (> b-size n) (.removeLast buf))
                  (.addFirst buf i)
                  buf))
              (LinkedList.)
              a-list)
      (.getLast)))

#_(nth-to-last-redux '(1 2 3 4 5 6 7 8 9 10 11 12 13 14) 1)

;; The reducer works however is not optimal because
;; we have to use another data structure. We could
;; do a loop and call next on the list manually
;; with two pointers
(defn nth-to-last-pointers
  [a-list n]
  (loop [tail a-list
         head (first (drop
                      (inc n)
                      (iterate next a-list)))]
    (if (nil? head)
      (first  tail)
      (recur (next tail) (next head)))))

#_(nth-to-last-pointers '(1 2 3 4 5 6 7 8 9 10) 0)

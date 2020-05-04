(ns interview-questions.08-Kth-frequent-string)

;;; Given a list of strings, find the k-th most
;;; frequent string.

;;; For all strings, add the string as a key
;;; to a dictionary, increment count for every
;;; occurrence.

;;; frequencies - gives a map {"abc" 2, "def" 1}
;;; Invert the map (drop duplicate keys), then order

(defn limit [x range-min range-max]
  (max (min x range-max) range-min))

(defn kth-most-frequent [input k]
  (-> input
    (frequencies)             ; {"abc" 2, "def" 1}
    (clojure.set/map-invert)  ; {2 "abc", 1 "def"} ;; Would drop duplicates!
    (into (sorted-map))
    (#(nth (seq %) (dec (limit k 1 (count %)))))))

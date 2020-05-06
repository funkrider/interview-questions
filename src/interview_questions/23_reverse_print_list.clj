(ns interview-questions.23-reverse-print-list)

;; Given a linked list reverse print the list
;; Assume this  could be the same as reversing a list in place
;; Questions: What does it contain? How long is it?

;; Two ways to do it: 1) Reverse the list then print 2) Recurse printing

(defn recurse-print-list [[x & xs]]
  (when (pos-int? (count xs))
    (recurse-print-list xs))
  (prn x))

(recurse-print-list '(1 2 3))


(defn reverse-then-print [l]
  (prn (reverse l)))

(reverse-then-print '(1 2 3))

(ns interview-questions.19-Balanced-binary-tree-test
  (:require [clojure.test :refer :all]
            [interview-questions.19-Balanced-binary-tree :refer :all]))

;;;         1
;;;    2         3
;;;  4   5     6   7
;;;   8      9 10 11 12
;;;         13
(def x-13 {:value 13 :left nil :right nil})
(def x-12 {:value 12 :left nil :right nil})
(def x-11 {:value 11 :left nil :right nil})
(def x-10 {:value 10 :left nil :right nil})
(def x-9 {:value 9 :left nil :right x-13})
(def x-8 {:value 8 :left nil :right nil})
(def x-7 {:value 7 :left x-11 :right x-12})
(def x-6 {:value 6 :left x-9 :right x-10})
(def x-5 {:value 5 :left nil :right nil})
(def x-4 {:value 4 :left nil :right x-8})
(def x-3 {:value 3 :left x-6 :right x-7})
(def x-2 {:value 2 :left x-4 :right x-5})
(def x-1 {:value 1 :left x-2 :right x-3})

;;;         1
;;;    2         3
;;;  4   5     6   7
;;;   8      9   11 12
;;;         13
;; Make y tree y-6 node have 2 left children
;; and no right children
(def y-13 {:value 13 :left nil :right nil})
(def y-12 {:value 12 :left nil :right nil})
(def y-11 {:value 11 :left nil :right nil})
;;(def y-10 {:value 10 :left nil :right nil})
(def y-9 {:value 9 :left nil :right y-13})
(def y-8 {:value 8 :left nil :right nil})
(def y-7 {:value 7 :left y-11 :right y-12})
(def y-6 {:value 6 :left y-9 :right nil}) ;; y-10
(def y-5 {:value 5 :left nil :right nil})
(def y-4 {:value 4 :left nil :right y-8})
(def y-3 {:value 3 :left y-6 :right y-7})
(def y-2 {:value 2 :left y-4 :right y-5})
(def y-1 {:value 1 :left y-2 :right y-3})

(testing "is a tree balanced"
  (is (> 0 (is-balanced-binary-tree? x-1)))
  (is (= -1 (is-balanced-binary-tree? y-1))))





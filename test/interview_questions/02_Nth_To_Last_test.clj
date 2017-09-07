(ns interview-questions.02-Nth-To-Last-test
  (:require [clojure.test :refer :all]
            [interview-questions.02-Nth-To-Last :refer :all]))

(testing "Nth to last"

  (is (= (nth-to-last '(:a :b :c :d :e :f :g :h) 0)
        :h))

  (is (= (nth-to-last '(:a :b :c :d :e :f :g :h) 1)
        :g))

  (is (= (nth-to-last '(:a :b :c :d :e :f :g :h) 7)
        :a))

  (is (= (nth-to-last '(:a :b :c :d :e :f :g :h) 8)
        nil))

  )

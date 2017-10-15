(ns interview-questions.20-Gray-Code-test
  (:require [clojure.test :refer :all]
            [interview-questions.20-Gray-Code :refer :all]))

(def x-001 1)
(def x-011 3)
(def x-010 2)
(def x-000 0)

(testing "is-gray-code?"
  (is (is-gray-code? x-001 x-011))
  (is (is-gray-code? x-000 x-001))
  (is (not (is-gray-code? x-001 x-010)))
  (is (not (is-gray-code? x-000 x-000))))
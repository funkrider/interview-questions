(ns interview-questions.14-Palindrome-test
  (:require [clojure.test :refer :all]
            [interview-questions.14-Palindrome :refer :all]))

(testing "palindrome"

  (is (= true (palindrome? "")))

  (is (= true (palindrome? nil)))

  (is (= true (palindrome? '())))

  (is (= true (palindrome? [])))

  (is (= true (palindrome? "a")))

  (is (= true (palindrome? "aba")))

  (is (= false (palindrome? "abc")))

  (is (= true (palindrome? '(\a))))

  (is (= false (palindrome? '(\a \b))))

  (is (= true (palindrome? '(\a \b \a))))

  (is (= true (palindrome? '(1))))

  (is (= false (palindrome? '(1 2))))

  (is (= true (palindrome? '(1 2 1))))

  )
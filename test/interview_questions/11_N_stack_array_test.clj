(ns interview-questions.11-N-stack-array-test
  (:require [clojure.test :refer :all]
            [interview-questions.11-N-stack-array :refer :all]
            [com.stuartsierra.component :as component]))

(binding [stack-count 3
          array-size 10
          data (atom (apply vector-of :char (repeat array-size \space)))
          available-index (atom (apply list (range 0 array-size)))
          used-stack-index (atom (apply vector (repeat stack-count '())))
          ]

  (testing "Stack management using a single array."

    (is (= @data [\space \space \space \space \space \space \space \space \space \space]))

    (is (= @available-index '(0 1 2 3 4 5 6 7 8 9)))

    (is (= @used-stack-index ['() '() '()]))

    (push-to-stack 0 \a)

    (is (= @data [\a \space \space \space \space \space \space \space \space \space]))

    (is (= @available-index '(1 2 3 4 5 6 7 8 9)))

    (is (= @used-stack-index ['(0) '() '()]))

    (push-to-stack 0 \b)

    (is (= @data [\a \b \space \space \space \space \space \space \space \space]))

    (is (= @available-index '(2 3 4 5 6 7 8 9)))

    (is (= @used-stack-index ['(1 0) '() '()]))


    (push-to-stack 1 \c)

    (is (= @data [\a \b \c \space \space \space \space \space \space \space]))

    (is (= @available-index '(3 4 5 6 7 8 9)))

    (is (= @used-stack-index ['(1 0) '(2) '()]))


    (push-to-stack 1 \d)

    (is (= @data [\a \b \c \d \space \space \space \space \space \space]))

    (is (= @available-index '(4 5 6 7 8 9)))

    (is (= @used-stack-index ['(1 0) '(3 2) '()]))

    (pop-from-stack 0)

    (is (= @data [\a \space \c \d \space \space \space \space \space \space]))

    (is (= @available-index '(1 4 5 6 7 8 9)))

    (is (= @used-stack-index ['(0) '(3 2) '()]))

    (pop-from-stack 0)

    (is (= @data [\space \space \c \d \space \space \space \space \space \space]))

    (is (= @available-index '(0 1 4 5 6 7 8 9)))

    (is (= @used-stack-index ['() '(3 2) '()]))

    (push-to-stack 2 \e)

    (is (= @data [\e \space \c \d \space \space \space \space \space \space]))

    (is (= @available-index '(1 4 5 6 7 8 9)))

    (is (= @used-stack-index ['() '(3 2) '(0)]))


    )

  )




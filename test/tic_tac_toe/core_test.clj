(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(deftest board-test
  (is (= [[:_ :_ :_][:_ :_ :_][:_ :_ :_]] board)))

(deftest print-board-test
  (testing "prints an empty tic-tac-toe board"
    (print (print-board))
    (is (= "\n_ _ _ \n_ _ _ \n_ _ _ \n" (print-board)))))

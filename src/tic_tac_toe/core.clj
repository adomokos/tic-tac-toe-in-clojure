(ns tic-tac-toe.core
  (require [tic-tac-toe.game :refer :all])
  (:gen-class))

(def state (atom :running))

(defn print-next-step [board move]
  (println (print-board board))
  (println (str "You moved to: " move)))

(defn run-game []
  (let [game-board (atom board)]
    (do
      (println "You are with X. Where do you want to move?")
      (while (= @state :running)
        (let [move (read-line)
              ]
          (if (pos? (count move))
            (try
              (do
                (swap! game-board record-user-move move)
                (swap! game-board record-computer-move)
                (print-next-step @game-board move))
              (catch IllegalArgumentException e
                (do
                  (print-next-step @game-board move)
                  (println "Sorry, incorrect move..."))))
            (reset! state :stop)))))))

(defn -main
  "The app runner"
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (run-game))

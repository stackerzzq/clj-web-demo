(ns quickstart.config
  (:use korma.db
        korma.core))

(defdb korma-db (mysql {:db "test",
                        :host "localhost",
                        :port 3306,
                        :user "homestead",
                        :password "secret"}))
(defproject quickstart "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                  [org.clojure/java.jdbc "0.7.1"]
                  [mysql/mysql-connector-java "5.1.44"]
                  [korma "0.4.3"]
                  [compojure "1.6.0"]
                  [selmer "1.11.0"]
                  [ring/ring-json "0.4.0"]]
  :main ^:skip-aot quickstart.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-ring "0.12.1"]]
  :ring {:handler quickstart.core/app
          :auto-reload? true
          :auto-refresh? true})

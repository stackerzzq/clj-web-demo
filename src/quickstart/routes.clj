(ns quickstart.routes
  (:use [compojure.core :only [GET POST PUT DELETE defroutes]]
        [compojure.route :only [not-found]]
        [quickstart.controller.course :as course]))
        
(defroutes app-routes

  (GET "/" request (course/home))

  (GET "/hello" request (str request))

  (POST "/courses" request (course/post-courses request))

  (GET "/rest/courses" [] (course/get-courses))

  (POST "/rest/courses" request (course/update-course request))

  (GET "/rest/courses/:id" [id] (course/get-course id))

  (DELETE "/rest/courses/:id" [id] (course/delete-course id))

  (not-found "<h1>page not found!</h1>"))

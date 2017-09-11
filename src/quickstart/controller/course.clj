(ns quickstart.controller.course
  (:use [quickstart.model.course :as course]
        [ring.util.response :only [response]])
  (:gen-class))

(defn home []
  (course/init-courses!)
  (response {:template "index.html",
    :model {:id "u-20141123-9091",
            :name "Michael"
            :courses (course/get-courses!)}}))

(defn post-courses [request]
  (let [params (:params request) {:keys [name price online days]} params]
    (course/create-course! {:id (str "c-" (System/currentTimeMillis)),
                      :name name,
                      :price (if (empty? price) 8.8 price),
                      :online (if (empty? online) true online),
                      :days (if (empty? days) 7 days)})
    (response (str "You have created course: " (:name params)))))

(defn update-course [request]
  (let [params (:params request) id (:id params)]
    (course/update-course! params)
    (response (course/get-course! id))))

(defn get-courses []
  (response { :courses (course/get-courses!)}))

(defn get-course [id]
  (response (course/get-course! id)))

(defn delete-course [id]
  (do
    (course/delete-course! id)
    (response {:id id})))

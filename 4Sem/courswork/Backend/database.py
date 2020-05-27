import dlib
from skimage import io
import numpy as np



sp = dlib.shape_predictor('shape_predictor_68_face_landmarks.dat')
facerec = dlib.face_recognition_model_v1('dlib_face_recognition_resnet_model_v1.dat')
detector = dlib.get_frontal_face_detector()


img = io.imread('test.jpg')
win1 = dlib.image_window()
win1.clear_overlay()
win1.set_image(img)
dets_webcam = detector(img, 1)
for k, d in enumerate(dets_webcam):
    print("Detection {}: Left: {} Top: {} Right: {} Bottom: {}".format(
        k, d.left(), d.top(), d.right(), d.bottom()))
    shape = sp(img, d)
    win1.clear_overlay()
    win1.add_overlay(d)
    win1.add_overlay(shape)

face_descriptor1 = facerec.compute_face_descriptor(img, shape)
np.save("database/test.npy", face_descriptor1)
print(face_descriptor1)






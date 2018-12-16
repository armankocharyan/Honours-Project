import numpy as np
import numpy
import csv

#CONSTANT VARIABLES:

PATH 			= "data/datasets/"
TRAINING_FILE 	= "prediction.data.training"
TESTING_FILE 	= "prediction.data.testing"

NUMBER_OF_EXAMPLES = 25000
NUMBER_OF_INPUTS = 11
NUMBER_OF_OUTPUTS = 2



#methods that help store the pokerhand data into Data class attributes
#Start....................

def data_set():
	return Data()


def read_data():
	print("LOADING: training data")
	training_X, training_y	= extract_data(TRAINING_FILE)
	print("Finished loading training data")
	print("LOADING: testing data")
	testing_X, testing_y 	= extract_data(TESTING_FILE)
	print("FINISHED loading testing data")
	return training_X, training_y, testing_X, testing_y

def extract_data(f):
		hands = []
		labels 	 = []
		with open(PATH + f) as csvfile:
			readCSV = csv.reader(csvfile, delimiter=',')
			numrows = 0
			for row in readCSV:
				features = np.zeros(11)
				for i in range(len(row)-1):
					features[i] = float(row[i])
				label = vectorize_label(row[len(row)-1])
				hands.append(features.tolist())
				labels.append(label.tolist())
		return np.asarray(hands), np.asarray(labels)

def vectorize_label(x): #One hot label


	label = np.zeros(2)
	label[int(x)] = 1
	return label
#End......................


#Class data
#Start....................
class Data:

	#Data constructor
	def __init__(self):

		#storing the training data sets into these variables from the read_data function
		self._training_X, self._training_y, self._testing_X, self._testing_y = read_data()

		self._num_examples = NUMBER_OF_EXAMPLES
		self._input_dim = NUMBER_OF_INPUTS
		self._output_dim = NUMBER_OF_OUTPUTS


		self._index_in_epoch = 0
		self._epochs_completed = 0


	#next_batch method returns a random batch from the dataset
	def next_batch(self, batch_size):
		start = self._index_in_epoch
		self._index_in_epoch += batch_size
		if self._index_in_epoch > self._num_examples:
			self._epochs_completed += 1
			perm = numpy.arange(self._num_examples)
			numpy.random.shuffle(perm)
			self._training_X = self._training_X[perm]
			self._training_y = self._training_y[perm]
			start = 0
			self._index_in_epoch = batch_size
			assert batch_size <= self.num_examples
		end = self._index_in_epoch
		return self._training_X[start:end], self._training_y[start:end]



	#data set attributes
	@property
	def training_X(self):
		return self._training_X

	@property
	def training_y(self):
		return self._training_yx

	@property
	def testing_X(self):
		return self._testing_X

	@property
	def testing_y(self):
		return self._testing_y

	@property
	def num_examples(self):
		return self._num_examples

	@property
	def output_dim(self):
		return self._output_dim

	@property
	def input_dim(self):
		return self._input_dim

#End......................


#main method
if __name__ == "__main__":
	data_set()

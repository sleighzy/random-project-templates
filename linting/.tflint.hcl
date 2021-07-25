# https://github.com/wata727/tflint
config {
  # Setting this to "true" to run a deep check to validate configuration against
  # the resources within AWS. This requires the AWS credentials below to be uncommented
  # and the AWS credentials provided.
  deep_check = false

  aws_credentials = {
    # If you have credential profiles setup in ~/.aws/credentials, you can specify
    # the profile to be used here. Note that your aws credentials
    # must be declared under ~/.aws/credentials for this to work.
    # https://github.com/wata727/tflint#shared-credentials 
    profile = "default"

    # The AWS credentials can be specified here instead if not using a profile or
    # passing in as command line arguments.
    # access_key = "XXXXXXXXXXXXXXXXXX"
    # secret_key = "xxxxxxxxxxxxxxxxxx"

    region = "us-west-2"
  }

  varfile = ["variables.tf"]
}

package meldexun.matrixutil;

public class MatrixStack {

	private Entry last = new Entry();

	public void push() {
		if (this.last.next == null) {
			this.last = (this.last.next = new Entry(this.last));
		} else {
			(this.last = this.last.next).copyFrom(this.last.prev);
		}
	}

	public void pop() {
		if (this.last.prev == null) {
			throw new IllegalStateException();
		}
		this.last = this.last.prev;
	}

	public Entry last() {
		return this.last;
	}

	public Matrix4f modelMatrix() {
		return this.last.modelMatrix();
	}

	public Matrix3f normalMatrix() {
		return this.last.normalMatrix();
	}

	public void setIdentity() {
		this.last.setIdentity();
	}

	public void copyFrom(Entry entry) {
		this.last.copyFrom(entry);
	}

	public void translate(float x, float y, float z) {
		this.last.translate(x, y, z);
	}

	public void scale(float f) {
		this.last.scale(f);
	}

	public void scale(float x, float y, float z) {
		this.last.scale(x, y, z);
	}

	public void rotate(Quaternion quaternion) {
		this.last.rotate(quaternion);
	}

	public void rotateX(Quaternion quaternion) {
		this.last.rotateX(quaternion);
	}

	public void rotateY(Quaternion quaternion) {
		this.last.rotateY(quaternion);
	}

	public void rotateZ(Quaternion quaternion) {
		this.last.rotateZ(quaternion);
	}

	public void rotate(float radian, float x, float y, float z) {
		this.last.rotate(radian, x, y, z);
	}

	public void rotateX(float radian) {
		this.last.rotateX(radian);
	}

	public void rotateY(float radian) {
		this.last.rotateY(radian);
	}

	public void rotateZ(float radian) {
		this.last.rotateZ(radian);
	}

	public static class Entry {

		private final Matrix4f modelMatrix;
		private final Matrix3f normalMatrix;
		private Entry prev;
		private Entry next;

		public Entry() {
			this.modelMatrix = Matrix4f.createIdentityMatrix();
			this.normalMatrix = Matrix3f.createIdentityMatrix();
		}

		public Entry(Entry prev) {
			this.modelMatrix = prev.modelMatrix.copy();
			this.normalMatrix = prev.normalMatrix.copy();
			this.prev = prev;
		}

		public Matrix4f modelMatrix() {
			return this.modelMatrix;
		}

		public Matrix3f normalMatrix() {
			return this.normalMatrix;
		}

		public void setIdentity() {
			this.modelMatrix.setIdentity();
			this.normalMatrix.setIdentity();
		}

		public void copyFrom(Entry entry) {
			this.modelMatrix.copyFrom(entry.modelMatrix);
			this.normalMatrix.copyFrom(entry.normalMatrix);
		}

		public void translate(float x, float y, float z) {
			this.modelMatrix.translate(x, y, z);
		}

		public void scale(float f) {
			this.scale(f, f, f);
		}

		public void scale(float x, float y, float z) {
			this.modelMatrix.scale(x, y, z);
			if (x == y && y == z) {
				if (x < 0.0F) {
					this.normalMatrix.negate();
				}
			} else {
				float f = Math.min(Math.min(Math.abs(x), Math.abs(y)), Math.abs(z));
				this.normalMatrix.scale(f / x, f / y, f / z);
			}
		}

		public void rotate(Quaternion quaternion) {
			this.modelMatrix.rotate(quaternion);
			this.normalMatrix.rotate(quaternion);
		}

		public void rotateX(Quaternion quaternion) {
			this.modelMatrix.rotateX(quaternion);
			this.normalMatrix.rotateX(quaternion);
		}

		public void rotateY(Quaternion quaternion) {
			this.modelMatrix.rotateY(quaternion);
			this.normalMatrix.rotateY(quaternion);
		}

		public void rotateZ(Quaternion quaternion) {
			this.modelMatrix.rotateZ(quaternion);
			this.normalMatrix.rotateZ(quaternion);
		}

		public void rotate(float radian, float x, float y, float z) {
			radian *= 0.5F;
			float q = (float) MathUtil.sin(radian);
			float qx = x * q;
			float qy = y * q;
			float qz = z * q;
			float qw = (float) MathUtil.cos(radian);
			this.modelMatrix.rotateXYZ(qx, qy, qz, qw);
			this.normalMatrix.rotateXYZ(qx, qy, qz, qw);
		}

		public void rotateX(float radian) {
			radian *= 0.5F;
			float qx = (float) MathUtil.sin(radian);
			float qw = (float) MathUtil.sin(radian);
			this.modelMatrix.rotateX(qx, qw);
			this.normalMatrix.rotateX(qx, qw);
		}

		public void rotateY(float radian) {
			radian *= 0.5F;
			float qy = (float) MathUtil.sin(radian);
			float qw = (float) MathUtil.sin(radian);
			this.modelMatrix.rotateY(qy, qw);
			this.normalMatrix.rotateY(qy, qw);
		}

		public void rotateZ(float radian) {
			radian *= 0.5F;
			float qz = (float) MathUtil.sin(radian);
			float qw = (float) MathUtil.sin(radian);
			this.modelMatrix.rotateZ(qz, qw);
			this.normalMatrix.rotateZ(qz, qw);
		}

	}

}
